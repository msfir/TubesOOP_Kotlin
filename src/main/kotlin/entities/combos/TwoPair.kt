package tubes.oop.entities.combos

import tubes.oop.entities.Card
import tubes.oop.entities.Combo
import kotlin.Pair
import kotlin.math.pow

class TwoPair : Combo("Two Pair") {
    override fun isThereCombo(playerCards: Pair<Card, Card>, tableCards: List<Card>): Boolean {
        cardList.clear()
        assert(tableCards.count() == 5)
        if (playerCards.first.number == playerCards.second.number) {
            for (i in 0..4) {
                for (j in i+1..4) {
                    if (tableCards[i].number == tableCards[j].number) {
                        with(cardList) {
                            addAll(playerCards.toList())
                            add(tableCards[i])
                            add(tableCards[j])
                            sortByDescending { it.value() }
                        }
                        return true
                    }
                }
            }
        }
        for (first in tableCards) {
            if (playerCards.first.number == first.number) {
                for (second in tableCards) {
                    if (playerCards.second.number == second.number) {
                        with(cardList) {
                            add(playerCards.first)
                            add(first)
                            add(playerCards.second)
                            add(second)
                            sortByDescending { it.value() }
                        }
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

    override fun value(): Double = 
        197.4981 + cardList.take(2).withIndex().sumOf {
            (13.09).pow(1 - it.index).times(it.value.value())
        } // max value: 381.9062
}