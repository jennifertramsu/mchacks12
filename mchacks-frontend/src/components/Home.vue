<template>
    <div id = 'content'>
        <div id ='header'>
            <div id = 'time'>
                <div v-if="this.phase === 'triaged' || this.phase ==='registered'" >
                    <p id="waiting-time"> {{ estimated_waiting }} </p>
                </div>
                <div v-else>
                    <p id="waiting-time"> N/A </p>
                </div>
                
                <p> Estimated Waiting Time in Minutes </p>
                <p> Next Step: {{ next_phase }} </p>
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
                        <p class="event-date">Triage</p>
                        <p class="event-description">
                            <p> Triage Category: {{ category_name}} </p>
                            <p> General Queue No.: {{ patientInfo.queue_position.global}} </p>
                            <p> Category Queue No.: {{ patientInfo.queue_position.category }}</p>
                        </p>
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
                        <p class="event-date">Investigation</p>
                        <div class="investigations-event-description">
                                <div v-if="patientInfo.status.investigations">
                                    <div v-if="patientInfo.status.investigations.labs">
                                        <p> Lab Investigations: {{ patientInfo.status.investigations.labs }}</p>  
                                    </div>
                                    <div v-else>

                                    </div>
                                    <div v-if="patientInfo.status.investigations.imaging">
                                        <p> Imaging Investigations: {{ patientInfo.status.investigations.imaging }}</p>
                                    </div> 
                                    <div v-else></div>                                
                                    
                                </div>
                                <div v-else>
                                    <p>N/A</p>
                                </div>    
                            </div>
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
                        <p class="event-date">Discharge</p>
                        <p class="event-description"></p>
                    </div>
                </div>
           
           
           
           
            </div>
        
            <div id = 'game'>
                <button @click = 'goToGame' >Bored?</button>
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
                CategoryNames: ['Resuscitation','Emergent','Urgent','Less Urgent','Non Urgent'],
                stats:[],
                category:0,
                category_name:'',
                status:'',
                phase_index: 0,
                PhaseNames: ['Admission','Triage','Registration','Investigation Pending','Treatment','Admission','Discharge'],
                phase: '',
                estimated_waiting: 0,
                next_phase:'',
            };
        },
        mounted(){
            //Fetch data when the component is mounted
            this.fetchPatientInfo();
            this.fetchStats();
        },
        methods:{
            async fetchPatientInfo(){
                try {
                    const response = await axios.get('https://ifem-award-mchacks-2025.onrender.com/api/v1/patient/anon_5679');
                    this.patientInfo = response.data;
                    this.category = this.patientInfo.triage_category -1;
                    this.category_name = this.CategoryNames[this.category];
                    this.status = this.patientInfo.status.current_phase;
                    console.log(this.status)

                    this.phase = this.patientInfo.status.current_phase
                    if (this.phase === 'admitted'){
                        this.phase_index = 0;
                    }else if (this.phase === 'registered'){
                        this.phase_index=1;
                    }else if (this.phase === 'triaged'){
                        this.phase_index=2;
                    }else if (this.phase ==='investigations_pending'){
                        this.phase_index=3;
                    }else if (this.phase ==='treatment'){
                        this.phase_index=4;
                    }else if (this.phase ==='discharged'){
                        this.phase_index=5;
                    }
                    console.log(this.patientInfo);                    
                    this.next_phase = this.PhaseNames[this.phase_index+1];


                    console.log(this.patientInfo.arrival_time)
                } catch(error){
                    console.error("Could not fetch data",error);
                }
                
            },

            async fetchStats(){
                try{
                const response = await axios.get('https://ifem-award-mchacks-2025.onrender.com/api/v1/stats/current');
                this.stats = response.data;
                this.estimated_waiting = this.stats.averageWaitTimes[this.category + 1] - this.patientInfo.time_elapsed;
                if (this.estimated_waiting < 0){
                    this.estimated_waiting = 0;
                }
                    console.log(this.stats)
                    console.log(this.category)
                } catch(error){
                    console.error("Could not fetch data",error);
                }
            },
            goToGame(){
                this.$router.push('/game');
            }
            
            
        }

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
    padding-bottom: 100px;
}

</style>