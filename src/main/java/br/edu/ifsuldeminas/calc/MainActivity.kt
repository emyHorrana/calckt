package br.edu.ifsuldeminas.calc
/*
Integrantes do grupo:
Andreza
Emily
Luriana
Raphaela
09/10/2024
*/

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextConta: EditText
    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnMais: Button
    private lateinit var btnMenos: Button
    private lateinit var btnDividir: Button
    private lateinit var btnMult: Button
    private lateinit var btnPonto: Button
    private lateinit var btnLimparT: Button
    private lateinit var btnIgual: Button
    private lateinit var btnDeletar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var conta: String = ""
        btn0 = findViewById(R.id.btn0)
        editTextConta = findViewById(R.id.editTextConta)


        fun deletar(int: Int) {
            if (conta.length > 0) {
                conta = conta.substring(0, conta.length - int) // O método substring irá retornar o valor da "conta" a partir do indice 0
                editTextConta.setText(conta)                    // até o ultimo valor menos INT, ou seja, ela faz o papel de apagar a ultimo caracter.
            }
        }

        fun limpar() { //Define "conta" = vazio.
            editTextConta.setText("")
            conta = ""
        }


//
        fun verificarOperacao(aux: String, operacao: String): String {
            var retorno: String = operacao
            if (aux == operacao) {
                retorno = ""
            } else if (operacao == "+") {
                if (aux == "-" || aux == "/" || aux == "*") {
                    retorno = "$operacao "
                    deletar(2)
                } else {
                    retorno = " + "
                }
            } else if (operacao == "-") {
                if (aux == "+" || aux == "/" || aux == "*") {
                    retorno = "$operacao "
                    deletar(2)
                } else {
                    retorno = " - "
                }
            } else if (operacao == "/") {
                if (aux == "+" || aux == "-" || aux == "*") {
                    retorno = "$operacao"
                    deletar(2)
                } else {
                    retorno = " / "
                }
            } else if (operacao == "*") {
                if (aux == "+" || aux == "/" || aux == "-") {
                    retorno = "$operacao "
                    deletar(2)
                } else {
                    retorno = " * "
                }
            } else {
                if (operacao == "+") {
                    retorno = " + "
                } else if (operacao == "-") {
                    retorno = " - "
                } else if (operacao == "/") {
                    retorno = " / "
                } else if (operacao == "*") {
                    retorno = " * "
                } else {
                    retorno = operacao
                }
            }
            return retorno
        }
        fun digite(s: String) {  //Passa o texto para o editTextConta, ou seja, para o usuário visualizar
            var auxS = s
            conta = editTextConta.text.toString()
            if (conta.length == 0) {
                if (s == "+" || s == "-" || s == "/" || s == "*") {
                    auxS = ""
                } else {
                    conta += auxS
                    editTextConta.append(conta) //Adiciona o novo valor de conta no editTextConta
                }
            } else {
                if (s == "+" || s == "-" || s == "/" || s == "*") {
                    if (conta.length > 1) { //Verifica se tem numero kkk
                        var auxS2 = conta[conta.length - 2].toString()
                        auxS = verificarOperacao(auxS2, s)
                        conta += auxS
                        editTextConta.setText(conta)
                    } else {
                        conta += " $s "
                        editTextConta.setText(conta)
                    }
                } else {
                    conta = auxS
                    editTextConta.append(conta)
                }
            }
        }
        fun executarOperacao(numero1: Double, operador: Char, numero2: Double): Double {
            var resultado: Double = 0.0
            if (operador == '+') {
                resultado = numero1 + numero2
            } else if (operador == '-') {
                resultado = numero1 - numero2
            } else if (operador == '/') {
                resultado = numero1 / numero2
            } else if (operador == '*') {
                resultado = numero1 * numero2
            }
            return resultado
        }
        fun calcular() { //Usada para organizar e definir os números e operadores.
            var expression = mutableListOf<Char>() //Cria uma lista de caracteres para armazenar os operadores
            for (i in conta.indices) {
                var string: String = conta.get(i).toString() //
                if (string == "+" || string == "-" || string == "/" || string == "*") {
                    expression.add(conta.get(i))
                }
            }
            var separador: List<String> = conta.split("+", "-", "*", "/")
            var array = separador.toMutableList()
            var int = 0
            try {
                while (expression.size != 0) {
                    var numero1 = array.get(0).toDouble()
                    var numero2 = array.get(1).toDouble()
                    var operador = expression.get(0)
                    var total: Double = 0.0
                    total = executarOperacao(numero1, operador, numero2)
                    array.removeAt(0)
                    expression.removeAt(0)
                    if (int == 0) {
                        array.removeAt(0)
                        int++
                    }
                    array.add(0, total.toString())
                }
                editTextConta.setText(array.get(0))
                conta = array.get(0)
            }catch (e :NumberFormatException){
                editTextConta.setText("0")
                conta = "0"
            }
        }

        btn0.setOnClickListener {
            digite("0")
        }
        btn1.setOnClickListener {
            digite("1")
        }
        btn2.setOnClickListener {
            digite("2")
        }
        btn3.setOnClickListener {
            digite("3")
        }
        btn4.setOnClickListener {
            digite("4")
        }
        btn5.setOnClickListener {
            digite("5")
        }
        btn6.setOnClickListener {
            digite("6")
        }
        btn7.setOnClickListener {
            digite("7")
        }
        btn8.setOnClickListener {
            digite("8")
        }
        btn9.setOnClickListener {
            digite("9")
        }
        btnMais.setOnClickListener {
            digite("+")
        }
        btnMenos.setOnClickListener {
            digite("-")
        }
        btnDividir.setOnClickListener {
            digite("/")
        }
        btnMult.setOnClickListener {
            digite("*")
        }
        btnPonto.setOnClickListener {
            digite(".")
        }
        btnLimparT.setOnClickListener {
            limpar()
        }
        btnIgual.setOnClickListener {
            calcular()
        }
        btnDeletar.setOnClickListener{
            deletar(1)
        }
    }
}
