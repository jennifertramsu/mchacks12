<template>
<div id ='game'>
    <div id="Top-bar">
        <button @click = "goToHome" id ="nav"> Back </button>
        <div id = 'points'> Points: {{ }}</div>
    </div>
    <div id="Question">
        {{this.question.question}}
    </div>
    <div id = "Answers">
    </div>
    </div>
</template>

<script>
// to do: change path from config + send api + points
import axios from 'axios';
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})
    export default{
        data(){
            return{
                answers: [],
                question: '',
            }

        },
        mounted(){
            this.loadQuestion();
            this.loadAnswers();
        },

        methods:{
            goToHome(){
                this.$router.push('/');
            },
            async loadQuestion(){
                const response = await AXIOS.get('./quiz/questions/random');
                this.question = response.data;
            },
            async loadAnswers(){ 
                response = await AXIOS.get('./quiz/questions/{this.question.id}/submission');
                this.answers = response.data;
                
                const answerContainer = document.getElementById("Answers");
                this.answers.forEach(answer=>{
                    const button = document.createElement('button');
                    button.textContent = answer.text;
                    button.id = answer.id;
                    button.addEventListener('click',()=>{
                        console.log("click!",button.id);
                        this.sendAnswer(button.id);
                    })
                    answerContainer.appendChild(button);
                })

            },
            sendAnswer(id){
                submission.player_id ='anon_5679';
                submission.question_Id = this.question.id;
                submission.answer_Id = id;
                AXIOS.post('./',submission);
                this.loadQuestion();
                this.loadAnswers();

            }
        }
    }
</script>

<style>
#nav{
    background-color: transparent;
    border-style:none;
}
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
.button{
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