<template>
    <div id="img">
        <!--source:https://opryshok.com/breathing-gif/-->
        <img src="../assets/box.gif" >
        <button @click = 'goToHome' class="nav-g" >Back</button>
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
#img{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items:center;
    padding-top:50%;
}

.nav-g{
    background-color: transparent;
    margin-top:50px;
    border-style: solid;
    width:40vw;
}
</style>