package tubes.oop.entities.combos

import tubes.oop.entities.Card
import tubes.oop.entities.Combo
import kotlin.Pair

class FourOfAKind : Combo("Four of a Kind"){
    override fun isThereCombo(playerCards: Pair<Card, Card>, tableCards: List<Card>): Boolean {
        assert(tableCards.count() == 5)
        cardList.clear()
        if (playerCards.first.number == playerCards.second.number) {
            val temp = mutableListOf<Card>()
            for (tableCard in tableCards) {
                if (tableCard.number == playerCards.first.number) {
                    temp.add(tableCard)
                }
            }
            if (temp.count() == 2) {
                cardList.addAll(playerCards.toList())
                cardList.addAll(temp)
                return true
            }
        }
        for (playerCard in playerCards.toList()) {
            val temp = mutableListOf<Card>()
            for (tableCard in tableCards) {
                if (tableCard.number == playerCard.number) {
                    temp.add(tableCard)
                }
            }
            if (temp.count() == 3) {
                cardList.add(playerCard)
                cardList.addAll(temp)
                return true
            }
        }
        return false
    }

    override fun clone(): Combo {
        val newObject = FourOfAKind()
        newObject.cardList.addAll(this.cardList)
        return newObject
    }

    override fun value(): Double = 261.9781 + cardList.first().value() // max value: 275,0681
}