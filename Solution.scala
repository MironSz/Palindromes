import math.max
import math.min

object Solution{
  def solution(s :String):Int={
    val tb="*"+s+"#"
    def symetry(a:Int, b:Int):Int={b+b-a}
    def manacherRec(ob:Int, r:Int, par:Int, prev:Int, res:Int,palLength:Array[Int]):Int={
      if(ob+r+1-par>=tb.length)
        return res+(0 until tb.length).foldLeft(0)((x:Int, y:Int)
          =>if(x>=1e8||x<0) -1 else x+palLength(y))

      if(tb(ob+r+1-par)==tb(ob-r-1))
        return manacherRec(ob,r+1,par,prev,res,palLength)

      palLength(ob)=r
      def Iter(j:Int,palLength:Array[Int]):Int={
        palLength(symetry(j,ob))=min  (palLength(j),   j-(ob-r));
        if(j-palLength(j)-1<=ob-r)
          return manacherRec( symetry(j,ob),  palLength(symetry(j,ob)), par , ob , res,palLength );
        else
          return Iter(j-1,palLength);
      }
      if(r>1) return  Iter(ob-1,palLength);
      else   return manacherRec(ob+max(palLength(ob)-par,1),0,par,ob,res,palLength);
    }
    var res=manacherRec(1, 0, 0, 0, 0, Array.fill(tb.length)(0) );
    res=manacherRec(1, 0, 1, 0, res, Array.fill(tb.length)(0) );
    if(res<0) res=(-1)
    return res
//////////////////////////////////////////
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

      def checkS(s:String):Boolean={
        if(solution(s)==brutForceSolution(s))
          return true
        else
        {
          println("expected "+brutForceSolution(s)+" but result is "+solution(s))
          return false
        }
      }
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
      def brutForceSolution(s:String):Int={
        var res=0

        val tb="%"+s+"&"
        for(i<-1 until tb.length-1)
        {
          for(par<-0 to 1)
          {
            var j=0
            while(tb(i+j+1-par)==tb(i-(j+1)))
              j+=1
            res+=j
          }
        }
        if(res<=1e8)
          return res
        return -1
      }
}
