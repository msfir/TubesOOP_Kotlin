package tubes.oop.entities.combos

import tubes.oop.entities.Card
import tubes.oop.entities.Combo
import kotlin.Pair

class TwoPair : Combo("Two Pair") {
    override fun isThereCombo(playerCards: Pair<Card, Card>, tableCards: List<Card>): Boolean {
        cardList.clear()
        assert(tableCards.count() == 5)
        if (playerCards.first.number == playerCards.second.number) {
            for (i in 0..4) {
                for (j in i+1..4) {
                    if (tableCards[i].number == tableCards[j].number) {
                        cardList.addAll(playerCards.toList())
                        cardList.addAll(tableCards.take(2))
                        cardList.sortByDescending { it.value() }
                        return true
                    }
                }
            }
        }
        for (first in tableCards) {
            if (playerCards.first.number == first.number) {
                for (second in tableCards) {
                    if (playerCards.second.number == second.number) {
                        cardList.add(playerCards.first)
                        cardList.add(first)
                        cardList.add(playerCards.second)
                        cardList.add(second)
                        cardList.sortByDescending { it.value() }
                        return true
                    }
                }
            }
        }
        return false
    }

    override fun clone(): Combo {
        val newObject = TwoPair()
        newObject.cardList.addAll(this.cardList)
        return newObject
    }

    override fun value(): Double = 26.18 + cardList[0].value() * 13.09 + cardList[2].value() // max value: 209.6181
}