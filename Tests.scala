import util.Random
import Solution._
import BrutForceSolution._


object  Tests {
  def Generator1(length:Int,word1:String,word2:String):String=
  {
    def Rec(a:String,b:String):String=if(a.length+b.length>=length) a+b else Rec(a+b,a)
    Rec(word1,word2)
  }
  def Generator2(length:Int,word1:String,word2:String):String=
  {
    def Rec(a:String,b:String):String=if(a.length+b.length>=length) a+b else Rec(a+b+a,b+a+b)
    Rec(word1,word2)
  }
  def OnlyA(n:Int):String={
    def Rec(m: Int,  sum: StringBuilder): String =
    {
      if(m==n) sum.toString
      else Rec(m+1, sum.append('a'))
    }
     Rec(0,new StringBuilder )
  }

  def check():Boolean={

    def checkS(s:String):Boolean={(solution(s)==brutForceSolution(s))}

    var res=true
    res&=checkS(OnlyA(100))
    res&=checkS(Generator1(100,"abba","bbbabbb"))
    res&=checkS(Generator2(100,"abba","bbbabbb"))
    res&=checkS("a")
    res&=checkS("mmiirroonn")
    res&=checkS("miron")
    res&=checkS("torot")
    res&=checkS("toror")
    res&=checkS("aa")
    res&=checkS("ab")
    res&=checkS("")
    return res

  }
  def main(args: Array[String]): Unit = {
    if(check())
      println("ok")
    else
      println("fail")
    }
}
