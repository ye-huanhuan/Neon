/**
 * 动态改变年页面的radio
 */
var date = new Date();
var year = date.getFullYear();
//改变第一张图的radio
var parent = document.getElementById("year");
var span1;
var year1;
var year1_content;
for(var j=2;j>=0;j--){
    span1 = document.createElement("span");
    year1 = document.createElement("input");
    year1.id = "year"+(year-j);
    year1.setAttribute("class","year");
    year1.setAttribute("type","radio");
    year1.setAttribute("name","year");
    year1.setAttribute("value",year-j);

    span1.insertBefore(year1,null);
    year1_content = document.createElement("span");
    year1_content.innerText = year -j;
    span1.appendChild(year1_content);
    parent.insertBefore(span1,parent.lastElementChild);
}