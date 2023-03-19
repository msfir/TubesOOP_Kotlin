package tubes.oop.entities

abstract class Card(private val number: Int) : Valuable {
    fun getNumber(): Int = number
}