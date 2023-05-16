<template>
    <v-card outlined style="border-radius: 0; max-height:15vh; margin-top:-10px;">
        <v-card-title>
            MachineView
        </v-card-title>
    
        <v-card-text>
            <v-row no-gutters style="margin: 15px 0px -30px -15px;">
                <v-col style="max-width:140px;">
                    <String class="attributes-list" label="MchCd" v-model="value.parameters.mchCd" :editMode="editMode"/>
                </v-col>
                <v-col>
                    <v-btn class="gs-query-search-btn"
                        @click="search"
                        flat
                        small
                    >
                        <v-icon small>mdi-magnify</v-icon>검색
                    </v-btn>
                </v-col>
            </v-row>
        </v-card-text>
    </v-card>
</template>

<script>
    export default {
        name: 'MachineViewQuery',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {
                apiPath: 'findByMchCd',
                parameters: {}
            },
        }),
        created() {
            this.value.parameters.mchCd = '';
        },
        watch: {
        },
        methods: {
            search() {
                let search = null;
                if(this.value.parameters.mchCd == '' ) {
                    search = null;
                }else{
                    search = this.value;
                }
                this.$emit('search', search);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>
<style>
.attributes-list{
    margin-left: 15px;
}
</style>

