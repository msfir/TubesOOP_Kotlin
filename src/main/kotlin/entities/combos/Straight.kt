package tubes.oop.entities.combos

import tubes.oop.entities.Card
import tubes.oop.entities.Combo
import kotlin.Pair

class Straight : Combo("Straight") {
    override fun isThereCombo(playerCards: Pair<Card, Card>, tableCards: List<Card>): Boolean {
        cardList.clear()
        val allCards = mutableListOf<Card>().apply {
            addAll(playerCards.toList())
            addAll(tableCards)
            sortByDescending { it.value() }
        }
        var straightCount = 1
        var currentRank = allCards.first().number
        val temp = mutableListOf(allCards.first())
        for (card in allCards.drop(1)) {
            if (card.number == currentRank - 1) {
                straightCount++
                currentRank--
                temp.add(card)
                if (straightCount == 5) {
                    if (temp.contains(playerCards.first) || temp.contains(playerCards.second)) {
                        cardList.addAll(temp)
                        return true
                    } else {
                        temp.removeFirst()
                        straightCount--
                    }
                }
            } else if (card.number == currentRank) {
                if (!temp.contains(playerCards.first) && !temp.contains(playerCards.second)
                    && playerCards.toList().contains(card)
                ) {
                    temp.removeAt(straightCount - 1)
                    temp.add(card)
                }
            } else {
                temp.clear()
                temp.add(card)
                straightCount = 1
                currentRank = card.number
            }
        }
        return false
    }

    override fun clone(): Combo {
        val newObject = Straight()
        newObject.cardList.addAll(this.cardList)
        return newObject
    }

    override fun value(): Double = 222.7081 + cardList.first().value() // max value: 235.7981
}