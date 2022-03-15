var removeCartItemButton = document.getElementsByClassName('remove-btn')
for(var i=0;i<removeCartItemButton.length;i++){
    var button = removeCartItemButton[i]
    button.addEventListener('click', function(event){
        var buttonClicked = event.target
        buttonClicked.parentElement.parentElement.parentElement.remove()
    })
}