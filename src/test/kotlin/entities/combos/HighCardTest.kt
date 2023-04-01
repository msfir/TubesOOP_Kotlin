package entities.combos

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import tubes.oop.entities.cards.BlueCard
import tubes.oop.entities.cards.RedCard
import tubes.oop.entities.combos.HighCard
import kotlin.test.assertEquals

class HighCardTest {
    private val combo = HighCard()
    @Test
    @Order(1)
    fun isThereCombo() {
        assertEquals(true, combo.isThereCombo(Pair(RedCard(13), BlueCard(3)), listOf()))
        assertEquals(RedCard(13), combo.cards.first())
        val cloned = combo.clone()
        assertEquals(13.09, cloned.cards.first().value())
        assertEquals(13.09, cloned.value())
    }
}