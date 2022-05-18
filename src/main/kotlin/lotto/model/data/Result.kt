package lotto.model.data

data class Result(val lotto: Lotto, val winning: Winning)
data class Results(val resultList: List<Result>)
