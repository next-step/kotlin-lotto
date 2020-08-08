package model

class Lotto(override val number: List<LottoNumber>) : BasicLotto {
    companion object {
        const val SIZE = 6
    }
}
