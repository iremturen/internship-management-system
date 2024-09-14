<template>
  <div class="card" style="color: #2c919c; background-color: #eeeeee">
    <div class="form-container">
      <label for="ogretmenID">Staff ID:</label>
      <input type="number" id="ogretmenID" name="ogretmenID" placeholder="Staff ID" />
    </div>
    <div class="form-container">
      <label for="fakulte">For Faculty:</label>
      <select id="fakulte" name="fakulte">
        <!-- Fakülte seçenekleri burada olacak -->
        <option value="fakulte1">Fakülte 1</option>
        <option value="fakulte2">Fakülte 2</option>
        <option value="fakulte3">Fakülte 3</option>
      </select>
    </div>
    <div class="form-container">
      <label for="department">For Department:</label>
      <select id="department" name="department">
        <!-- Departman seçenekleri burada olacak -->
        <option value="department1">Departman 1</option>
        <option value="department2">Departman 2</option>
        <option value="department3">Departman 3</option>
      </select>
    </div>
    <div class="button-container">
      <button type="button">Assing New Staff</button>
    </div>
  </div>
</template>
<style scoped>
@import url('../../../../assets/css/style.css');
.material-symbols-outlined {
  font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 48;
}
.button-container {
  text-align: right;
}
button {
  background-color: #0e163d;
  color: #fff;
  padding: 8px 16px;
  width: 40%;
  border: none;

  cursor: pointer;
}
</style>
