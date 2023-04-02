package tubes.oop.entities.combos

import tubes.oop.entities.Card
import tubes.oop.entities.Combo
import tubes.oop.entities.cards.BlueCard
import tubes.oop.entities.cards.GreenCard
import tubes.oop.entities.cards.RedCard
import tubes.oop.entities.cards.YellowCard
import kotlin.Pair
import kotlin.math.pow

class Flush : Combo("Flush") {
    override fun isThereCombo(playerCards: Pair<Card, Card>, tableCards: List<Card>): Boolean {
        cardList.clear()
        val allCards = mutableListOf<Card>()
        with(allCards) {
            addAll(playerCards.toList())
            addAll(tableCards)
            sortByDescending { it.value() }
        }
        val greenCards = allCards.filterIsInstance<GreenCard>()
        val blueCards = allCards.filterIsInstance<BlueCard>()
        val yellowCards = allCards.filterIsInstance<YellowCard>()
        val redCards = allCards.filterIsInstance<RedCard>()
        val groupedCards = listOf(greenCards, blueCards, yellowCards, redCards)
        for (group in groupedCards) {
            if (group.count() > 4) {
                cardList.addAll(group.take(5))
                if (cardList.contains(playerCards.first) || cardList.contains(playerCards.second)) {
                    return true
                }
                if (group.count() > 5) {
                    with(cardList) {
                        removeFirst()
                        add(group[5])
                    }
                    return true
                }
                return false
            }
        }
        return false
    }

    override fun clone(): Combo {
        val newObject = Flush()
        newObject.cardList.addAll(this.cardList)
        return newObject
    }

    override fun value(): Double =
        416292.094783165 + cardList.withIndex().sumOf {
            (13.09).pow(4 - it.index).times(it.value.value())
        } // max value: 829774.38133733
}