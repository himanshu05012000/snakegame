package com.example.myapplication

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import stanford.androidlib.graphics.*
import java.lang.Math.abs

private var dirx=1f
private var diry=0f
private var Posx=0f
private var Posy=0f
private val sqsize=100f
private var snsize=1;
private const val XSWIPE = 200f
private const val YSWIPE = 200f
private var block=GRect(Posx+2*sqsize, Posy, sqsize, sqsize)
private var arr=ArrayList<GRect>()
 private var dirarrx=ArrayList<Float>()
 private  var dirarry=ArrayList<Float>()
var block1=GRect(Posx+1* sqsize, Posy, sqsize, sqsize)
var block2=GRect(Posx, Posy, sqsize, sqsize)
class Rocketplay(context:Context,attri:AttributeSet): GCanvas(context,attri){
    override fun init() {

        block.fillColor=GColor.GREEN
        add(block)
        dirarrx.add(1f)
        dirarry.add(0f)
        arr.add(block)
        arr.add(block1)
        arr.add(block2)
        var x1:Float = 0f
        var x2:Float = 0f
        var y1:Float = 0f
        var y2:Float = 0f
        setOnTouchListener{ _,event ->

            if(event.action == MotionEvent.ACTION_DOWN){
                x1 = event.x
                y1 = event.y
            }
            if(event.action == MotionEvent.ACTION_UP){
                x2 = event.x
                y2 = event.y
                if(x1>x2 && abs(x1-x2)> XSWIPE){

                    dirx=-1f
                    diry=0f
                }else if(x1<x2 && abs(x1-x2)> XSWIPE) {
                    //RIGHT
                    dirx=1f
                    diry=0f
                }else if(y1>y2 && abs(y1-y2)> YSWIPE){
                    //UP
                    dirx=0f
                    diry=-1f
                }else if(y2>y1 && abs(y1-y2)> YSWIPE){
                    //DOWN
                    dirx=0f
                    diry=1f
                }
            }

            true

        }
        block1.fillColor=GColor.GREEN
        add(block1)

        block2.fillColor=GColor.GREEN
        add(block2)

        animate(60)
        {
            move()
            dirarrx.add(dirx)
            dirarry.add(diry)
        }
    }
    fun move()
    {
        var n= dirarrx.size
        var i=0
        for(blo in arr)
        {
            var mvx= dirarrx[n-1]
            var mvy= dirarry[n-1]
            if(n-1-i>=0)
            {
                mvx= dirarrx[n-1-i]
                mvy= dirarry[n-1-i]
            }
            blo.moveBy(mvx,mvy)
            i++
        }
    }

}