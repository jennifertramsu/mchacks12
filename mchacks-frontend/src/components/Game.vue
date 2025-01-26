<template>
<div id ='game'>
    <div id="Top-bar">
        <button @click = "goToHome"> Back </button>
        <div id = 'points'> Points: {{ }}</div>
    </div>
    <div id="Question">
        What is the meaning of life? 
    </div>
    <div id = "Answers">
        <div class ="answer"> Happy </div>
        <div class ="answer"> Hell </div>
        <div class ="answer"> Cats </div>
        <div class ="answer"> Calculating the Jacobian</div>
    </div>
    </div>
</template>

<script>
    export default{
        methods:{
            goToHome(){
                this.$router.push('/');
            }
        }
    }
</script>

<style>
#Top-bar{
    height:fit-content;
    display:flex;
    justify-content: space-between;
    margin-right: 10%;
    margin-left:10%;
}
#game{
    padding-top: 5%;
    padding-bottom: 50px;
}
#Answers{
    display: grid;
    column-gap: 20px;
    row-gap:20px;
}
#Question{
    height:30vh;
    display:flex;
    justify-content:center;
    align-items:center;
    font-size:28px;
    padding:10%;
}
.answer{
    display:flex;
    justify-content: center;
    align-items: center;
    background-color: whitesmoke;
    height: 10vh;
    margin-right:10%;
    margin-left:10%;
    align-self: center;
    text-align: center;
    border-radius: 20px;
}

</style>