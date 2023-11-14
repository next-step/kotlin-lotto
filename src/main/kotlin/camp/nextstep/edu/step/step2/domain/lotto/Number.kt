package camp.nextstep.edu.step.step2.domain.lotto

@JvmInline
value class Number(
    val number: Int
) {

    init {
        require(number in 1..45) { "로또 번호는 1~45 사이여야 합니다." }
    }

}
