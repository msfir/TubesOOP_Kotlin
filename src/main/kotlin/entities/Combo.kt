package tubes.oop.entities

abstract class Combo(val name: String) : Cloneable, Valuable {
    protected val cardList: MutableList<Card> = mutableListOf()
    val cards get() = cardList.toList()

    abstract fun isThereCombo(playerCards: Pair<Card, Card>, tableCards: List<Card>): Boolean
    public abstract override fun clone() : Combo
}