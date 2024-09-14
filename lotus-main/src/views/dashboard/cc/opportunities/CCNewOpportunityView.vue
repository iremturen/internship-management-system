<script>
import { onMounted, ref } from 'vue'
import { putOpportunity } from '../../../../../src/api/opportunity.api'
import useCareerCenterStore from '../../../../../src/stores/careercenter.store'

export default {
  setup() {
    const companyName = ref('')
    const task = ref('')
    const location = ref('')
    const deadline = ref('')

    const careercenterStore = useCareerCenterStore()

    const submit = async () => {
      const response = {
        date: '2 Haziran',
        pdf: '',
        url: 'https://upload.wikimedia.org/wikipedia/tr/b/ba/%C3%9Csk%C3%BCdar_%C3%9Cniversitesi_logo.png',
        location: location.value,
        deadline: deadline.value,
        companyName: companyName.value,
        title: 'New Opportunity '
      }

      await putOpportunity(response)

      alert('New Opportunity Added')
    }

    return {
      submit,
      task,
      companyName,
      location,
      deadline
    }
  }
}
</script>
<template>
  <div style="display: flex; padding-left: 10%; width: 93%; gap: 2%; margin-top: 40px">
    <div style="width: 100%">
      <div style="display: flex; flex-direction: column; margin-bottom: 20%; gap: 20px">
        <label>Internship Task:</label>
        <input
          type="text"
          name=""
          id=""
          style="
            padding: 20px;
            background-color: #f1f1f1;
            border-radius: 20px;
            font-size: large;
            border: none;
          "
          placeholder="Internship Task"
          v-model="task"
        />
        <label>Company Name:</label>
        <input
          type="text"
          name=""
          id=""
          style="
            padding: 20px;
            background-color: #f1f1f1;
            border-radius: 20px;
            font-size: large;
            border: none;
          "
          placeholder="Company Name"
          v-model="companyName"
        />
        <label>Locations:</label>
        <input
          type="text"
          name=""
          id=""
          style="
            padding: 20px;
            background-color: #f1f1f1;
            border-radius: 20px;
            font-size: large;
            border: none;
          "
          placeholder="Locations"
          v-model="location"
        />
      </div>

      <div style="display: flex; flex-direction: column; gap: 20px; margin-top: -90px">
        <label>Application Deadline:</label>
        <input
          type="datetime"
          name=""
          id=""
          placeholder="dd/mm/yyyy"
          style="
            padding: 20px;
            background-color: #f1f1f1;
            border-radius: 20px;
            font-size: large;
            border: none;
          "
          v-model="date"
        />
      </div>
    </div>

    <div style="width: 100%; height: 100%">
      <div style="display: flex; flex-direction: column; gap: 20px; margin-bottom: 3%">
        <label for="">Logo:</label>
        <div
          style="
            display: flex;
            flex-direction: row;
            gap: 10px;
            padding: 20px;
            background-color: #f1f1f1;
            border-radius: 20px;
            font-size: large;
            border: none;
          "
        >
          <input
            type="file"
            class="button"
            accept="image/*"
            style="
              margin-top: 15px;
              margin-left: 6px;
              border-radius: 5px;
              color: rgb(78, 78, 78);
              height: 7vh;
              width: 100%;
            "
          />
        </div>
      </div>

      <div style="display: flex; flex-direction: column; gap: 20px; margin-bottom: 3%">
        <label for="">More Details:</label>
        <input
          type="text"
          placeholder=""
          style="
            background-color: #a6ccd1;
            width: 100%;
            border-radius: 7px;
            height: 30vh;
            border: none;
          "
        />
      </div>

      <button
        style="
          padding: 20px;
          color: #f1f1f1;
          background-color: #0e163d;
          width: 100%;
          border-radius: 20px;
          height: 11vh;
          font-size: x-large;
          font-weight: 500;
        "
        @click.prevent="submit"
      >
        Add New Opportunity
      </button>
    </div>
  </div>
</template>

<style scoped>
@import url('../../../../assets/css/style.css');
.material-symbols-outlined {
  font-variation-settings: 'FILL' 0, 'wght' 500, 'GRAD' 0, 'opsz' 48;
  color: white;
  margin-right: 50px;
}
button:hover {
  color: white;
}
</style>
