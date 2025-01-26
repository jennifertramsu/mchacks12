<template>
    <div>
        <p>Longest wait time: {{ total }}</p>
        <p v-for="item in items" :key="item.id"> Patient: 
            {{ item.arrival_time }}, 
            {{ item.id }},
            {{ item.queue_position.global }},
            {{ item.queue_position.category }}
        </p>
    </div>
</template>

<script>
export default {
    data() {
        return {
            total: 0,
            items: []
        };
    },
    mounted() {
        fetch("https://ifem-award-mchacks-2025.onrender.com/api/v1/queue")
            .then(response => response.json())
            .then(data => {
                this.total = data["longestWaitTime"];
                this.patients = data["patients"];
                for (let i = 0; i < this.patients.length; i++) {
                    this.items.push(this.patients[i]);
                }
            });
    }
};
</script>