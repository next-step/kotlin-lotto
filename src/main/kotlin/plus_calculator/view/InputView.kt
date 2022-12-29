package plus_calculator.view

class InputView private constructor() {

    companion object {
        fun input(): String {
            return readln()
        }
    }
}