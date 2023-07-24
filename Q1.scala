import scala.io.StdIn

object Q1 {
  def main(args: Array[String]): Unit = {
    print("Enter the Text: ")
    val Text = StdIn.readLine()
    val shift = 3
    println()

    val encryptedT = Cipher(Text, shift,encrypt)
    println("Encrypted text: "+encryptedT)

    val decryptedT = Cipher(encryptedT, shift, decrypt)
    println("Decrypted text: " + decryptedT)
  }

  def Cipher (Text: String, shift: Int, cipherFunc: (String, Int)=> String): String={
    cipherFunc(Text, shift)
  }
  def encrypt(Text: String, shift: Int): String ={
    val alphabet = 26
    Text.map{ character =>
      if (character.isLetter){
        val base = if (character.isUpper) 'A' else 'a'
        ((character-base+shift) % alphabet + base).toChar
      }else{
        character
      }
    }
  }
  def decrypt(Text: String, shift: Int): String = {
    encrypt(Text, -shift)
  }

}
