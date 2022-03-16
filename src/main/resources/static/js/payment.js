
$(document).ready(function(){
    let removeCartItemButton = document.getElementsByClassName('remove-btn')
    console.log(removeCartItemButton)
    console.log(removeCartItemButton.length)
    for(var i=0;i<removeCartItemButton.length;i++){
        var button = removeCartItemButton[i]
        button.addEventListener('click', function(event){
            var buttonClicked = event.target
            buttonClicked.parentElement.parentElement.parentElement.remove()
            updateTotal()
        })
    }
})


function updateTotal(){
    var cartItemContainer = document.getElementsByClassName('cart-items')[0]
    var cartRows = cartItemContainer.getElementsByClassName('cart-row')
    var total = 0
    for (var i = 0; i< cartRows.length;i++){
        var cartRow = cartRows[i]
        var priceElement = cartRow.getElementsByClassName('cart-price')[0]
        var quantityElement = cartRow.getElementsByClassName('cart-quantity')[0]
        var price = priceElement.innerText.replace('€','')
        var quantity = quantityElement.value
        total = total + (price * quantity)
    }
    document.getElementsByClassName('total-price')[0].innerText ="€" + total
}