//下面是一条弹窗
//alert("标识符！");
// 声明变量
//box=100 声明变量初始化
//alert(box)以弹窗的方式输出box的值

 /*
  *var boxString='clong';
  *alert(boxString);
  * 
 */
function box(){
	var sum=0;
	for (var i = 0; i < arguments.length ; i++) {
		sum+=arguments[i];
	}
	return sum;
}
alert(box(10,20,30,40,50));