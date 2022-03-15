var removeCartItemButton = document.getElementsByClassName('remove-btn')
console.log(removeCartItemButton)
for(var i=0;i<removeCartItemButton.length;i++){
    var button = removeCartItemButton[0]
    console.log(button)
    button.addEventListener('click', function(event){
        var buttonClicked = event.target
        buttonClicked.parentElement.parentElement.parentElement.remove()
        updateTotal()
    })
}

function updateTotal(){
    var cartItemContainer = document.getElementsByClassName('cart-items')[0]
    var cartRow = cartItemContainer.getElementsByClassName('cart-row')
    var total = 0
    console.log(cartRow)
}