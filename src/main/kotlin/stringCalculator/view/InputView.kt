package stringCalculator.view

object InputView {

    fun getUserTemplate(): String {
        println("Please enter a value. ex) 1:2:3")
        return checkUserInput(readLine())
    }

    fun checkUserInput(input: String?): String {
        if (input.isNullOrBlank()) {
            print(input)
            return "0"
        }
        return input
    }
}
