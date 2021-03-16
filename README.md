# Step2
- [ ] 구입금액 입력이 가능하다. -> InputView
    - [X] 로또의 가격은 1000원이다.
        - [X] 1000원 보다 적으면 Exception -> Input(amount: Int)
        - [ ] 1000원 보다 많으면 / 1000의 갯수만큼 구매가 가능하다. -> Input.count -> amount / 1000
    
- [ ] 여러개의 로또를 구매가 가능하다. -> LottoCollection
    - [ ] 로또 개수만큼 만들 수 있다. -> LottoCollection(int, generator)
        - [ ] 인자로는 로또 개수, 생성기를 주입이 가능하다.
    - [ ] 로또 당첨 번호를 받아서, 등수를 return 할 수 있어야 한다 -> LottoCollection.getRanks() -> LottoRanks
        - [ ] LottoRanks에는 6,5,4,3개 일치한 값의 갯수를 가지고 있어야 한다. -> LottoRank(Rank: enums, count)
            - [ ] Rank는 스스로 당첨금액을 알고 있어야 한다. ( enums ) 
                - [ ] Rank는 당첨갯수를 기반으로 몇등인지 return이 가능해야한다 -> Rank.getRank(맞은갯수: int)
            - [ ] LottoRanks는 스스로 총합금액을 return할줄 알아야 한다 -> LottoRank.sum() -> Int
      
    - [ ] 로또는 6개의 숫자를 갖고 있다 -> Lotto
        - [ ] 생성시 LottoNumber을 같이 생성한다.
        - [ ] 로또 넘버 생성기를 주입이 가능해야 한다 
        - [ ] 로또의 숫자는 랜덤적으로 생성이 가능하다 -> LottoNumberRandomGenerator
        - [ ] 로또 숫자는 1~45까지 갖고 있다 -> LottoNumber
        - [ ] 로또의 숫자는 중첩이 불가능하다 -> Set
- [ ] 출력 시 LottoCollection.getRanks() 를 통해 출력을 한다.
    - [ ] LottoRanks.sum() / LottoCollection.lotto.size * 1000 을 수익률로 보여준다.