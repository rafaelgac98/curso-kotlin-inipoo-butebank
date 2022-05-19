fun main() {
    println("Bem vindo ao ByteBank!")
    val contaAlex = Conta(titular = "Alex", numero = 1000)
    contaAlex.deposita(-200.0)

    val contaFran = Conta(numero = 1001, titular = "Fran")
    contaFran.deposita(300.00)

    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println()

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println("Depositando na conta do Alex...")
    contaAlex.deposita(50.0)
    println("Saldo atual R$${contaAlex.saldo}")
    println()
    println("Depositando na conta da Fran...")
    contaFran.deposita(70.0)
    println("Saldo atual R$${contaFran.saldo}")
    println()
    println("Sacando da conta do Alex...")
    contaAlex.saca(80.0)
    println()
    println("Transferindo de Alex para Fran...")
    contaAlex.transfere(1500.0, contaFran)

}


class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set


    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
            println("Deposito de R$$valor efetuado. Seu saldo atual eh R$${this.saldo}.")
        } else {
            println("Tentativa de deposito de valor invalido $valor. Favor depositar valor valido.")
        }

    }

    fun saca(valor: Double) {

        if (saldo >= valor) {
            saldo -= valor
            println("Saque de R$$valor efetuado. Seu saldo atual eh R$$saldo.")
        } else {
            println("Saldo insuficiente. Seu saldo eh R$$saldo.")
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            println("Transferencia no valor de R$$valor para ${destino.titular} efetuada com sucesso. Seu saldo atual eh R$$saldo.")
            return true
        }
        println("Saldo insuficiente. Seu saldo atual eh R$$saldo.")
        return false
    }

//    fun getSaldo(): Double {
//        return saldo
//    }
//
//    fun setSaldo(valor: Double) {
//        if (valor > 0) {
//            saldo = valor
//        }
//    }

}

fun testaCopiasEReferencias() {
    var numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("O valor de numeroX é: $numeroX")
    println("O valor de numeroY é: $numeroY")

    val contaJoao = Conta("Joao", 1002)
    val contaMaria = Conta("Maria", 1003)

    println("Titular conta joao: ${contaJoao.titular}")
    println("Titular conta maria: ${contaMaria.titular}")
}

fun testaLacos() {

    var i = 0
    while (i < 5) {

        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0


        println(
            "Titular: $titular \n" +
                    "Numero da conta: $numeroConta \n" +
                    "Saldo: $saldo"
        )
        testeCondicoes(saldo)
        println("----------------------------")
        i++

    }

    for (i in 5 downTo 1 step 2) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0


        println(
            "Titular: $titular \n" +
                    "Numero da conta: $numeroConta \n" +
                    "Saldo: $saldo"
        )
        println("----------------------------")
    }
}

fun testeCondicoes(saldo: Double) {
    if (saldo > 0.0) println("O valor da sua conta eh positivo!")
    else if (saldo == 0.0) println("O valor da sua conta eh neutra!")
    else println("O valor da sua conta eh negativo!")

//    Exemplo do mesmo código acima porém com When!

//    when {
//        saldo > 0.0 -> println("conta é positiva")
//        saldo == 0.0 -> println("conta é neutra")
//        else -> println("conta é negativa")
//    }
}
