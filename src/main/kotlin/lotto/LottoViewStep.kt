package lotto

sealed class LottoViewStep<out T> {
    abstract fun apply(lottoMachine: LottoMachine): LottoResult<T>
}