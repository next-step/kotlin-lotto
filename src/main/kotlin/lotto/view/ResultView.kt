package view

import entity.Card
import entity.Player

class OutputView {
    fun printCardConsole(name: String, cards: MutableList<Card>) {
        var printMsg = "${name}카드: ${cards.joinToString { "," }}"
        println(printMsg)
    }

    fun splitCard(players: List<Player>) {
        var splitCardMsg = "${(players.map { it.name }).joinToString(",")}에게 2장의 나누었습니다."
        println(splitCardMsg)
    }
}
