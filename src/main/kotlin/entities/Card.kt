package tubes.oop.entities

abstract class Card(open val number: Int) : Valuable {
    abstract  override fun equals(other: Any?): Boolean
}