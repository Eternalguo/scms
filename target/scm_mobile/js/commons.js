function getAbsPosition(o) {
    o = $(o);
    if (o.length == 0){
        return false;
    }
    var left, top;
    o = o[0];
    left = o.offsetLeft;
    top = o.offsetTop;
    while(o=o.offsetParent) {
        left += o.offsetLeft;
        top += o.offsetTop;
    }
    return {
        left:left,
        top:top
    };
}