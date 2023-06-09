package tubes.oop.entities.combos

import tubes.oop.entities.Card
import tubes.oop.entities.Combo
import kotlin.Pair
import kotlin.math.pow

class ThreeOfAKind : Combo("Three of a Kind") {
    override fun isThereCombo(playerCards: Pair<Card, Card>, tableCards: List<Card>): Boolean {
        cardList.clear()
        assert(tableCards.count() == 5)
        if (playerCards.first.number == playerCards.second.number) {
            for (tableCard in tableCards) {
                if (tableCard.number == playerCards.first.number) {
                    cardList.addAll(playerCards.toList())
                    cardList.add(tableCard)
                    cardList.sortByDescending { it.value() }
                    return true
                }
            }
        }
        for (playerCard in playerCards.toList()) {
            for (i in 0..4) {
                if (playerCard.number == tableCards[i].number) {
                    for (j in i+1..4) {
                        if (playerCard.number == tableCards[j].number) {
                            cardList.add(playerCard)
                            cardList.add(tableCards[i])
                            cardList.add(tableCards[j])
                            cardList.sortByDescending { it.value() }
                            return true
                        }
                    }
                }
            }
        }
        return false
    }

    override fun clone(): Combo {
        val newObject = ThreeOfAKind()
        newObject.cardList.addAll(this.cardList)
        return newObject
    }

    override fun value(): Double = 
        381.9062 + cardList.withIndex().sumOf {
            (13.09).pow(2 - it.index).times(it.value.value())
        } // max value: 2808.838229
}