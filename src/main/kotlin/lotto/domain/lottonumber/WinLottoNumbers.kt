package lotto.domain.lottonumber

data class WinLottoNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber,
) {

    init {
        require(lottoNumbers.value.contains(bonusNumber).not()) {
            "bonus number can not be duplicated with lotto numbers"
        }
    }
}
