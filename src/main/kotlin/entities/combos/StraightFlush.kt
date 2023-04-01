package tubes.oop.entities.combos

import tubes.oop.entities.Card
import tubes.oop.entities.Combo
import tubes.oop.entities.cards.BlueCard
import tubes.oop.entities.cards.GreenCard
import tubes.oop.entities.cards.RedCard
import tubes.oop.entities.cards.YellowCard
import kotlin.Pair

class StraightFlush : Combo("Straight Flush") {
    override fun isThereCombo(playerCards: Pair<Card, Card>, tableCards: List<Card>): Boolean {
        cardList.clear()
        val allCards = mutableListOf<Card>()
        with(allCards) {
            addAll(playerCards.toList())
            addAll(tableCards)
        }
        val greenCards = allCards.filterIsInstance<GreenCard>()
        val blueCards = allCards.filterIsInstance<BlueCard>()
        val yellowCards = allCards.filterIsInstance<YellowCard>()
        val redCards = allCards.filterIsInstance<RedCard>()
        allCards.clear()
        if (greenCards.count() < 5 && blueCards.count() < 5 && yellowCards.count() < 5 && redCards.count() < 5) {
            return false
        } else if (greenCards.count() >= 5) {
            allCards.addAll(greenCards)
        } else if (blueCards.count() >= 5) {
            allCards.addAll(blueCards)
        } else if (yellowCards.count() >= 5) {
            allCards.addAll(yellowCards)
        } else if (redCards.count() >= 5) {
            allCards.addAll(redCards)
        }
        if (!allCards.contains(playerCards.first) && !allCards.contains(playerCards.second)) {
            return false
        }
        allCards.sortByDescending { it.value() }
        val temp = mutableListOf(allCards.first())
        var straightCount = 1
        var currentRank = allCards.first().number
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
        val newObject = StraightFlush()
        newObject.cardList.addAll(this.cardList)
        return newObject
    }

    override fun value(): Double = 275.0681 + cardList.first().number // max value: 288.1581
}