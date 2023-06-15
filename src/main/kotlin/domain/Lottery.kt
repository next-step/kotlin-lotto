package domain

class Lottery {

    val randomNumber = (1..45).shuffled().take(6)
}
