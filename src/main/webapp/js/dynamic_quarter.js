/**
 * 动态改变季度页面的radio
 */
var date = new Date();
var year = date.getFullYear();
var month = date.getMonth()+1;
//改变第一张图的radio
var parent = document.getElementById("quarter");
var span1;
var year1;
var year1_content;
for(var j=2;j>=0;j--){
    span1 = document.createElement("span");
    year1 = document.createElement("input");
    year1.id = "year"+(year-j);
    year1.setAttribute("class","quarter");
    year1.setAttribute("type","radio");
    year1.setAttribute("name","first_quarter");
    year1.setAttribute("value",year-j);

    span1.insertBefore(year1,null);
    year1_content = document.createElement("span");
    year1_content.innerText = year -j;
    span1.appendChild(year1_content);
    parent.insertBefore(span1,parent.lastElementChild);
}
//改变第二张图的radio
var parent2 = document.getElementById("second_quarter");
    var span2;
    var year2;
    var year2_content;
    for(var j=2;j>=0;j--){
        span2 = document.createElement("span");
        year2 = document.createElement("input");
        year2.id = "second_year_"+(year-j);
        year2.setAttribute("class","quarter");
        year2.setAttribute("type","radio");
        year2.setAttribute("name","second_quarter");
        year2.setAttribute("value",year-j);

        span2.insertBefore(year2,null);
        year2_content = document.createElement("font");
        year2_content.innerText = year -j;
        span2.appendChild(year2_content);
        parent2.insertBefore(span2,parent2.children[parent2.childElementCount-2]);
    }
    //第三张图radio
    
    var parent3 = document.getElementById("third_quarter");
    var span3;
    var year3;
    var year3_content;
    for(var j=0;j<4;j++){
        span3 = document.createElement("span");
        year3 = document.createElement("input");
        year3.id = "third_quarter_"+((Math.ceil(month/3)+j)%4+1);
        year3.setAttribute("class","quarter");
        year3.setAttribute("type","radio");
        year3.setAttribute("name","third_quarter");
        year3.setAttribute("value",(Math.ceil(month/3)+j)%4+1);
        span3.insertBefore(year3,null);
        year3_content = document.createElement("font");
        year3_content.innerText = ((Math.ceil(month/3)+j)%4+1)+"季度";
        span3.appendChild(year3_content);
        parent3.insertBefore(span3,parent3.lastElementChild);
    }