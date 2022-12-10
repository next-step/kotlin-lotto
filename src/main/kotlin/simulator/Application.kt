package simulator

import simulator.io.Input
import simulator.io.Output
import simulator.lotto.NumberGenerator

fun main() {
    val input = Input()
    val output = Output()
    val generator = NumberGenerator()

    val simulator = Simulator(input, output, generator)
    simulator.run()
}