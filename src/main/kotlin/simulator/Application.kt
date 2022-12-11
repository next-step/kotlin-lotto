package simulator

import simulator.io.Input
import simulator.io.Output

fun main() {
    val input = Input()
    val output = Output()
    val simulator = Simulator(input, output)
    simulator.run()
}