package tubes.oop.entities.combos

import tubes.oop.entities.Card
import tubes.oop.entities.Combo

class Pair : Combo("Pair") {
    override fun isThereCombo(playerCards: kotlin.Pair<Card, Card>, tableCards: List<Card>): Boolean {
        cardList.clear()
        assert(tableCards.count() == 5)
        val sortedPlayerCards = playerCards.toList().sortedByDescending { it.value() }
        if (sortedPlayerCards[0].number == sortedPlayerCards[1].number) {
            cardList.addAll(sortedPlayerCards)
            return true
        }
        for (playerCard in sortedPlayerCards) {
            for (tableCard in tableCards) {
                if (playerCard.number == tableCard.number) {
                    cardList.add(playerCard)
                    cardList.add(tableCard)
                    cardList.sortByDescending { it.value() }
                    return true
                }
            }
        }
        return false
    }

    override fun clone(): Combo {
        val newObject = Pair()
        newObject.cardList.addAll(this.cardList)
        return newObject
    }

    override fun value(): Double = 13.09 + cardList.first().value() // max value: 26.18 
}