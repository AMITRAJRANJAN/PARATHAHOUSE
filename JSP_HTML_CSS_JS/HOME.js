var parathaselector=document.getElementById('PARATHASELECTOR');
var quantity=document.getElementById('QUANTITY');
parathaselector.onchange=ratecalculator;
quantity.oninput=totalamountcalculator;

function totalamountcalculator()
{
    var rate2=document.getElementById('RATE').value;
    var quantity2=document.getElementById('QUANTITY').value;
    rate3=rate2.split(' ')[1];
    var amount=rate3*quantity2;
    document.getElementById('TOTALAMOUNT').value="Rs "+amount;
}

function ratecalculator()
{
    var paratha=document.getElementById('PARATHASELECTOR').value;
    var price;
    switch(paratha)
    {
        case 'Aaloo Paratha':
            price='Rs 50';
            break;
            
        case 'Paneer Paratha':
            price='Rs 75';
            break;
            
        case 'Sattu Paratha':
            price='Rs 50';
            break;
        
        case 'Khowa Paratha':
            price='Rs 100';
            break;
            
        case 'Tisi Paratha':
            price='Rs 100';
            break;
            
        default:
            price='Rs ';
            break;
    }
    var rate=document.getElementById('RATE');
    rate.value=price;
}

