package lotto_auto.lotto

data class Lotto(
    val numberList: List<Int> = createLotto(),
) {
    init {
        require(numberList.toSet().count() == NUMBER_LIST_COUNT) { COUNT_IS_WRONG }
        require(numberList.count { it < MIN_NUMBER || it > MAX_NUMBER } < NUMBER_COUNT_NOT_IN_RAGE) { NUMBER_NOT_IN_RANGE }
    }

    companion object {
        private const val NUMBER_LIST_COUNT = 6
        private const val COUNT_IS_WRONG = "생성된 로또 번호의 개수가 틀렸습니다"
        private const val NUMBER_NOT_IN_RANGE = "생성한 번호가 1~45에 있지 않습니다"
        private const val NUMBER_COUNT_NOT_IN_RAGE = 1
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private fun createLotto(): List<Int> = (MIN_NUMBER..MAX_NUMBER).shuffled().take(NUMBER_LIST_COUNT).sorted()
    }
}

fun List<Int>.toLotto() = Lotto(numberList = this)
