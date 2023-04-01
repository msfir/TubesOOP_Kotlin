package tubes.oop.entities.combos

import tubes.oop.entities.Card
import tubes.oop.entities.Combo
import tubes.oop.entities.cards.BlueCard
import tubes.oop.entities.cards.GreenCard
import tubes.oop.entities.cards.RedCard
import tubes.oop.entities.cards.YellowCard
import kotlin.Pair

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
        groupedCards.forEach {
            if (it.count() > 4) {
                cardList.addAll(it.take(5))
                if (cardList.contains(playerCards.first) || cardList.contains(playerCards.second)) {
                    return true
                }
                if (it.count() > 5) {
                    with(cardList) {
                        removeFirst()
                        add(it[5])
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

    override fun value(): Double = 235.7981 + cardList.first().value() // max value: 248.8881
}