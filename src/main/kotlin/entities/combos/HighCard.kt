package tubes.oop.entities.combos

import tubes.oop.entities.Card
import tubes.oop.entities.Combo
import kotlin.Pair

class HighCard : Combo("High Card") {
    override fun isThereCombo(playerCards: Pair<Card, Card>, tableCards: List<Card>): Boolean {
        cardList.clear()
        cardList.add(playerCards.toList().maxBy { it.value() })
        return true
    }

    override fun clone(): Combo {
    val newObject = HighCard()
        newObject.cardList.addAll(this.cardList)
        return newObject
    }

    override fun value(): Double {
        return cardList.first().value()
    }
}