package stringcalculator

class Inputformular() {
    fun stol(formular: String?): List<String> {
        if (formular.isNullOrBlank()) {
            throw IllegalArgumentException("Null값과 Blank는 허용이 안됩니다.")
        }
        return formular.trim().split(" ")
    }
}
