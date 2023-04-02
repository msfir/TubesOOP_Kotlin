package tubes.oop.entities.combos

import tubes.oop.entities.Card
import tubes.oop.entities.Combo
import kotlin.Pair
import kotlin.math.pow

class FullHouse : Combo("Full House") {
    override fun isThereCombo(playerCards: Pair<Card, Card>, tableCards: List<Card>): Boolean {
        assert(tableCards.count() == 5)
        cardList.clear()
        val allCards = mutableListOf<Card>()
        with(allCards) {
            addAll(playerCards.toList())
            addAll(tableCards)
            sortByDescending { it.value() }
        }
        var foundPair = false
        var foundTriplet = false
        val temp1 = mutableListOf<Card>()
        val temp2 = mutableListOf<Card>()
        var i = 0
        while (i < 5) {
            if (allCards[i].number == allCards[i + 1].number
                && allCards[i + 1].number == allCards[i + 2].number
            ) {
                temp1.addAll(allCards.drop(i).take(3))
                foundTriplet = true
                i += 2
            } else if (allCards[i].number == allCards[i + 1].number) {
                temp2.addAll(allCards.drop(i).take(2))
                foundPair = true
                i++
            }
            if (foundTriplet && foundPair) {
                val temp = temp1.toMutableList().also { it.addAll(temp2) }
                if (temp.contains(playerCards.first) || temp.contains(playerCards.second)) {
                    cardList.addAll(temp)
                    return true
                }
            }
            i++
        }
        return false
    }

    override fun clone(): Combo {
        val newObject = FullHouse()
        newObject.cardList.addAll(this.cardList)
        return newObject
    }

    override fun value(): Double = 
        829774.38133733 + cardList.take(3).withIndex().sumOf {
            (13.09).pow(2 - it.index).times(it.value.value())
        } // max value: 832201.31336633
}