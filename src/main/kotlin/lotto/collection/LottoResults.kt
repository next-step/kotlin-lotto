package lotto.collection

class LottoResults(matchedList: List<Int>) {
    var results = mutableMapOf<String, Int>()
        private set

    init {
        require(matchedList.size == LottoTicket.NUMBER_COUNT + 1){"matchedList 는 ${LottoTicket.NUMBER_COUNT + 1}개 여야 합니다"}

        matchedList.forEachIndexed { index, matchedCount ->
            results["$index"] = matchedCount
        }
    }

}

