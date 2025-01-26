<template>
    <div id = 'content'>
        <div id ='header'>
            <div id = 'time'>
                <p id="waiting-time"> 25 </p>
                <p> Estimated Waiting Time in Minutes </p>
                <p> Next Step: </p>
            </div>
        
            <div id = 'breathing'>
            </div>

        </div>

        <div id = 'body'>
            <div id = 'timeline'>
                <div class = 'timeline-item'>
                    <div class="event-dot"></div>
                    <div class="event-content">
                        <p class="event-date">Admission</p>
                        <p class="event-description"></p>
                    </div>
                </div>

                <div class = 'timeline-item'>
                    <div class="event-dot"></div>
                    <div class="event-content">
                        <p class="event-date">Registration</p>
                        <p class="event-description"></p>
                    </div>
                </div>
           
                <div class = 'timeline-item'>
                    <div class="event-dot"></div>
                    <div class="event-content">
                        <p class="event-date">Triage</p>
                        <p class="event-description">
                            <p> Triage Category: </p>
                            <p> General Queue No.: </p>
                            <p> Category Queue No.: </p>
                        </p>
                    </div>
                </div>
           
                <div class = 'timeline-item'>
                    <div class="event-dot"></div>
                    <div class="event-content">
                        <p class="event-date">Investigation</p>
                        <p class="event-description">
                            <p>General Queue No.: </p>
                            <p>Category Queue No.: </p>
                        </p>
                    </div>
                </div>

                <div class = 'timeline-item'>
                    <div class="event-dot"></div>
                    <div class="event-content">
                        <p class="event-date">Treatment</p>
                        <p class="event-description"></p>
                    </div>
                </div>

                <div class = 'timeline-item'>
                    <div class="event-dot"></div>
                    <div class="event-content">
                        <p class="event-date">Discharged</p>
                        <p class="event-description"></p>
                    </div>
                </div>
           
           
           
           
            </div>
        
            <div id = 'game'>
                <div class = 'button'> Bored? </div>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    
    export default{
        name: 'PatientInfo',
        data(){
            return{
                patientInfo: [],
                arrival_time:0, //to store the fetched data
            };
        },
        mounted(){
            //Fetch data when the component is mounted
            this.fetchPatientInfo();
        },
        methods:{
            async fetchPatientInfo(){
                try {
                    const response = await axios.get('https://ifem-award-mchacks-2025.onrender.com/api/v1/patient/anon_5679');
                    this.arrival_time = response.data;
                } catch(error){
                    console.error("Could not fetch data",error);
                }
                
            },
        },

    };
</script>

<style>
.button{
    background-color:black;
    width: 5%;
    height: 10%;
    writing-mode: vertical-lr;
    text-orientation: mixed;
    color: white;


}
.header{
    width: 100%;
    flex-direction:row;
}
.time{
    width: 40%;
}
#waiting-time{
    font-size: 92px;
}
.timeline {
  position: relative;
  width: 50%;
  padding-left: 20px;
}

.timeline-item {
  width: 80%;
  border-right-width: 5px;
  border-right-style: solid;
  position: relative;
  padding-left: 20px;
  padding-bottom: 20px;
  justify-content: right;
}

.event-dot {
  position: absolute;
  right: -12px;
  top: 0;
  width: 20px;
  height: 20px;
  background-color: black;
  border-radius: 50%;
}

.event-content {
  padding-right: 5%;
  text-align: right;
}

.event-date {
  font-weight: bold;
}

.event-description {
  background-color: #f1f1f1;
  width: 100%;
  margin-top: 5px;
  text-align: right;
}

#content{
    padding-top: 10%;
    padding-bottom: 50px;
    background-image:linear-gradient(180deg,#7cf3ff,#fffeda,white);
}

</style>