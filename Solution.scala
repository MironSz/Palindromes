import math.max
import math.min
import scala.annotation.tailrec

object Solution{
  def solution(s :String):Int={
    val word="*"+s+"#"
    def symetry(a:Int, b:Int):Int={b+b-a}
    @tailrec
    def manacherRec(act:Int, r:Int, even:Int, prev:Int, res:Int,palLength:Array[Int]):Int={
      if(act+r+1-even>=word.length)
        return (0 until word.length).foldLeft(res)((x:Int, y:Int)
          =>if(x>=1e8||x<0) -1 else x+palLength(y))

      if(word(act+r+1-even)==word(act-r-1))
         manacherRec(act,r+1,even,prev,res,palLength)
      else{
        palLength(act)=r
        @tailrec
        def Iter(j:Int):Int={
          palLength(symetry(j,act))=min  (palLength(j),   j-(act-r))
          if(j-palLength(j)-1<=act-r)
            symetry(j,act)
          else
            Iter(j-1);
        }
        if(r>1)
        {
          val next=Iter(act-1)
          manacherRec(next,palLength(next),even,act,res,palLength)
        }
        else   manacherRec(act+max(palLength(act)-even,1),0,even,act,res,palLength)
      }
    }
    var res=manacherRec(1, 0, 0, 0, 0, Array.fill(word.length)(0) )
    res=manacherRec(1, 0, 1, 0, res, Array.fill(word.length)(0) )
    if(res<0) res=(-1)
    res
  }
}
