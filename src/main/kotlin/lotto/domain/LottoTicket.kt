package lotto.domain

class LottoTicket {
    val lottoNumbers = (1..45).toSet().shuffled().take(6).sorted()
}
